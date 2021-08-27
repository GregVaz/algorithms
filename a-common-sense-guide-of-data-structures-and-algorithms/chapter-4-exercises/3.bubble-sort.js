function bubbleSort(array) {
    let isSorted = false
    let count = 0
    
    while(!isSorted) {
        isSorted = true
        for(let i = 0; i < array.length; i++) {
            if(array[i] > array[i + 1]) {
                let tmp = array[i + 1]
                array[i + 1] = array[i]
                array[i] = tmp
                isSorted = false
            }
            count++
        }
    }
    console.log(`Times of loops: ${count}`)
    return array
}

console.log(bubbleSort([1,5,11,5,43,342,6,2354,2,56,3]))