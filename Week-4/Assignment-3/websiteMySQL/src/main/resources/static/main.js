const signInForm = document.getElementById('signInForm');
const signUpForm = document.getElementById('signUpForm');

function UploadUserForm(request_url, event) {
    event.preventDefault(); // Prevent default form submission
    const email = event.target.querySelector('[name="email"]').value;
    const password = event.target.querySelector('[name="password"]').value;

    if (email.trim() === '' || password.trim() === '') {  // check email, password not empty
        alert('Email and password cannot be empty');
    } else {
        // fetch request
        fetch(request_url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        })
            .then(response => {
                if (!response.ok) { // fetch error
                    return response.text().then(errorMessage => {
                        throw new Error(errorMessage);
                    });
                }
                // fetch succcess
                console.log("Success");
                window.location.href = "/memberPage";
            })
            .catch(error => {
                console.error('Error:', error.message);
                const errorMessageElement = document.createElement('div');
                errorMessageElement.textContent = error.message;
                errorMessageElement.style.color = "red";
                document.body.appendChild(errorMessageElement);
            });
    }
}

signInForm.addEventListener('submit', event => UploadUserForm('api/v1/signIn', event));
signUpForm.addEventListener('submit', event => UploadUserForm('api/v1/signUp', event));
