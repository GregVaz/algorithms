function selectionSort(array) {
    let steps = 0
    for(let i = 0; i < array.length; i++) {
        let lowestIndex = i
        for(let j = i + 1; j < array.length; j++) {
            steps++
            if (array[j] < array[lowestIndex]) {
                lowestIndex = j
            }
        }
        if(lowestIndex !== i) {
            let tmp = array[i]
            array[i] = array[lowestIndex]
            array[lowestIndex] = tmp
        }
    }
    console.log(`Steps: ${steps}`)
    return array
}

console.log(selectionSort([1,5,11,5,43,342,6,2354,2,56,3]))