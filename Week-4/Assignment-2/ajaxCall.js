function ajax(src, callback) { // your code here
    fetch(src)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => callback(data)) // render page
        .catch(error => console.error('Error fetching data:', error));
}
function render(data) {
    const productList = document.createElement('product-list');
    // loop through data
    data.forEach(product => {
        // create product div container
        const productItem = document.createElement('div');
        productItem.classList.add('product-item'); // add class name

        // product name
        const nameElement = document.createElement('h2');
        nameElement.textContent = product.name;

        // product price
        const priceElement = document.createElement('p');
        priceElement.textContent = `Price: ${product.price}`;

        // product description
        const descriptionElement = document.createElement('p');
        descriptionElement.textContent = product.description;

        // append elements to productItem
        productItem.appendChild(nameElement);
        productItem.appendChild(priceElement);
        productItem.appendChild(descriptionElement);

        // append productItem to productList
        productList.appendChild(productItem);
    })
    // add product list to the page
    document.body.appendChild(productList);
}
ajax( 'https://remote-assignment.s3.ap-northeast-1.amazonaws.com/products',
    function (response) {
    render(response);
    }
);