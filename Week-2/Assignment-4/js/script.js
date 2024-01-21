// Request 1 =========================
// 1. access to welcome banner
const welcome_banner = document.querySelector('.banner h1')

// 2. addEventListener
welcome_banner.addEventListener( 'click', ()=> {
    welcome_banner.textContent = 'Have a Good Time!';
}
)

// Request 2 =========================
// 1. access to hidden content and call to action button
const content = document.querySelector('.hidden-content')
const button = document.querySelector('.js-btn')

// 2. addEventListener
button.addEventListener( 'click', ()=> {
    content.style.display = 'flex';
}
)