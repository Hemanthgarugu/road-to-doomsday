const loginScreen = document.getElementById("loginScreen");
const appContent = document.getElementById("appContent");
const loginUsername = document.getElementById("loginUsername");
const loginPassword = document.getElementById("loginPassword");
const loginButton = document.getElementById("loginButton");
const logoutButton = document.getElementById("logoutButton");
const userNameDisplay = document.getElementById("userNameDisplay");
const movieContainer = document.getElementById("movieContainer");
const progressFill = document.querySelector(".progress-fill");
const progressCount = document.getElementById("progressCount");
const progressPercent = document.getElementById("progressPercent");
const timerDays = document.getElementById("days");
const timerHours = document.getElementById("hours");
const timerMinutes = document.getElementById("minutes");
const timerSeconds = document.getElementById("seconds");

function showLogin() {
    loginScreen.classList.remove("hidden");
    appContent.style.display = "none";
}

function showApp(userName) {
    loginScreen.classList.add("hidden");
    appContent.style.display = "block";
    userNameDisplay.textContent = userName;
    document.querySelector(".login-status").classList.remove("hidden");
}

function handleLogin() {
    const username = loginUsername.value.trim();
    const password = loginPassword.value;

    if (!username || password.length < 4) {
        alert("Enter a username and a password with at least 4 characters.");
        return;
    }

    localStorage.setItem("rttdUser", username);
    showApp(username);
    loadMovies();
}

function handleLogout() {
    localStorage.removeItem("rttdUser");
    loginUsername.value = "";
    loginPassword.value = "";
    document.querySelector(".login-status").classList.add("hidden");
    showLogin();
}

function updateProgress(watchedCount, totalCount) {
    const percentage = totalCount ? Math.round((watchedCount / totalCount) * 100) : 0;

    if (progressFill) {
        progressFill.style.width = `${percentage}%`;
    }

    if (progressCount) {
        progressCount.textContent = `${watchedCount} / ${totalCount} movies watched`;
    }

    if (progressPercent) {
        progressPercent.textContent = `${percentage}%`;
    }
}

function updateCountdown() {
    const targetDate = new Date("2026-12-31T00:00:00");
    const now = new Date();
    const diff = targetDate - now;

    if (diff <= 0) {
        timerDays.textContent = "0";
        timerHours.textContent = "00";
        timerMinutes.textContent = "00";
        timerSeconds.textContent = "00";
        return;
    }

    const days = Math.floor(diff / (1000 * 60 * 60 * 24));
    const hours = Math.floor((diff / (1000 * 60 * 60)) % 24);
    const minutes = Math.floor((diff / (1000 * 60)) % 60);
    const seconds = Math.floor((diff / 1000) % 60);

    timerDays.textContent = days;
    timerHours.textContent = hours.toString().padStart(2, "0");
    timerMinutes.textContent = minutes.toString().padStart(2, "0");
    timerSeconds.textContent = seconds.toString().padStart(2, "0");
}

function loadMovies() {
    if (!movieContainer) {
        return;
    }

    fetch("/api/movies")
        .then(response => response.json())
        .then(movies => {
            movieContainer.innerHTML = "";

            let watchedCount = 0;

            movies.forEach(movie => {
                if (movie.watched) {
                    watchedCount += 1;
                }

                const card = document.createElement("div");
                card.className = "movie-card" + (movie.watched ? " watched" : "");

                card.innerHTML = `
                    <h2>${movie.id}. ${movie.title}</h2>
                    <p>${movie.description}</p>
                    <p><strong>Release:</strong> ${movie.releaseDate}</p>
                    <p><strong>Phase:</strong> ${movie.phase}</p>
                    <p><strong>Importance:</strong> ${movie.importance}</p>
                    <label>
                        <input
                            type="checkbox"
                            ${movie.watched ? "checked" : ""}
                            onchange="toggleWatched(${movie.id}, this.checked)"
                        >
                        Watched
                    </label>
                `;

                movieContainer.appendChild(card);
            });

            updateProgress(watchedCount, movies.length);
        })
        .catch(error => {
            console.error("Error loading movies:", error);
            movieContainer.innerHTML = "<p>Unable to load movies.</p>";
        });
}

function toggleWatched(id, watched) {
    fetch(`/api/movies/${id}`)
        .then(response => response.json())
        .then(movie => {
            movie.watched = watched;
            return fetch(`/api/movies/${id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(movie)
            });
        })
        .then(() => {
            loadMovies();
        })
        .catch(error => {
            console.error("Error updating movie:", error);
        });
}

function initApp() {
    const savedUser = localStorage.getItem("rttdUser");

    if (savedUser) {
        showApp(savedUser);
        loadMovies();
    } else {
        showLogin();
    }

    updateCountdown();
    setInterval(updateCountdown, 1000);
}

loginButton.addEventListener("click", handleLogin);
logoutButton.addEventListener("click", handleLogout);

initApp();
