function delayedResultPromise(n1, n2, delayTime) { // your code here
    return new Promise(function (resolve) {
        setTimeout(() => resolve(n1 + n2), delayTime);
    });
}

delayedResultPromise(4, 5, 3000).then(console.log);
// 9 (4+5) will be shown in the console after 3 seconds

