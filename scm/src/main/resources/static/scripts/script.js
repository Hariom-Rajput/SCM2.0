// set theme to local storage
function setTheme(theme, icon) {
    console.log("set theme function");
    localStorage.setItem("theme", theme);
    localStorage.setItem("icon", icon);
}

// get theme from local storage
function getTheme() {
    console.log("get theme function");
    let curr_theme = localStorage.getItem("theme");
    return curr_theme ? curr_theme : "light";
}

// get theme icon from local storage
function getThemeIcon() {
    let curr_icon = localStorage.getItem("icon");
    return curr_icon ? curr_icon : "fa-moon";
}

// apply theme on page load
function applyThemeOnLoad() {
    let current_theme = getTheme();
    let theme_icon = getThemeIcon();

    // Apply the theme and icon to the page
    document.querySelector('html').classList.add(current_theme);
    
    const themeIconElement = document.querySelector('#theme_icon');
    
    // Remove any previously applied icon classes (fa-moon, fa-sun)
    themeIconElement.classList.remove("fa-moon", "fa-sun");
    
    // Add the icon class stored in local storage
    themeIconElement.classList.add(theme_icon);
}

// change theme function
function change_theme() {
    const changeThemeBtn = document.querySelector("#theme_change_button");
    
    changeThemeBtn.addEventListener("click", () => {
        let current_theme = getTheme();
        let theme_icon = getThemeIcon();
        const old_theme = current_theme;
        const old_icon = theme_icon;

        // if current_theme is light then make it dark
        if (current_theme === "light") {
            current_theme = "dark";
            theme_icon = "fa-sun";
        } else {
            current_theme = "light";
            theme_icon = "fa-moon";
        }

        // remove the old theme and icon
        document.querySelector('html').classList.remove(old_theme);
        document.querySelector('#theme_icon').classList.remove(old_icon);

        // update the theme in local storage
        setTheme(current_theme, theme_icon);

        // apply the new theme and icon
        document.querySelector('html').classList.add(current_theme);
        document.querySelector('#theme_icon').classList.add(theme_icon);
    });
}

// Apply theme on page load
applyThemeOnLoad();
change_theme();