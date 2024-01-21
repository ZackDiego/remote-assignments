function avg(data) { // your code here
    price_arr = data.products     // access product array
        .map( prod => prod.price);   // get an array of products' prices
    
    const avg_func = arr => arr.reduce( ( a, b ) => a + b, 0 ) / arr.length;
    const avg_res = avg_func(price_arr);

    return avg_res;
}

console.log( 
    avg({
        size: 3, 
        products: [
            { name: 'Product 1', price: 100 },
            { name: 'Product 2', price: 700 },
            { name: 'Product 3', price: 250 }
        ]
    })
); // should print the average price of all products


