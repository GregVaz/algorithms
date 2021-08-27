function linearSearch(array, value) {
    let count = 0

    for(let i = 0; i < array.length; i++) {
        count++
        if(array[i] == value) {
            return i
        }
    }
    console.log(`Times of loops: ${count}`)
    return null
}

console.log(linearSearch([1,5,11,5,43,56,342,2354,756,342332,54646,34,35], 34))