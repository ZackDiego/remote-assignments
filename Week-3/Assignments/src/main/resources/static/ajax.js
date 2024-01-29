function calculateSum() {
    // Get the value of N from the user input
    const num = document.getElementById("number").value;

    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById("calculate_result").innerText = this.responseText;
        }
    };
    xhr.open("GET", "http://localhost:3000/data?number=" + num);
    xhr.send();
}