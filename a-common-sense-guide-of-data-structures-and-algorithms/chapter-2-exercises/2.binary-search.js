function binarySearch(array, value) {
    let leftIndex = 0
    let rightIndex = array.length - 1
    let middleIndex
    let count = 0
    while(leftIndex < rightIndex) {
        count++
        middleIndex = parseInt(( leftIndex + rightIndex ) / 2, 10)
        let mid = array[middleIndex]
        if(mid === value) {
            return middleIndex
        } else if(mid > value) {
            rightIndex = middleIndex - 1
        } else {
            leftIndex = middleIndex + 1
        }
    }
    console.log(`Times of loops: ${count}`)
    return null
}

console.log(binarySearch([1, 5, 11, 34, 35, 43, 56, 342, 756, 2354, 54646, 342332], 34))