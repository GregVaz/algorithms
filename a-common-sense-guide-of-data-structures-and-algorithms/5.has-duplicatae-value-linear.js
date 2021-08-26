function hasDuplicateValue(array) {
    let steps = 0
    let existingNumbers = []
    for(let i = 0; i < array.length; i++) {
        steps++
        if(existingNumbers[array[i]] === 1) {
            return true
        } else {
            existingNumbers[array[i]] = 1
        }
    }
    console.log(`Steps: ${steps}`)
    return false
}

console.log(hasDuplicateValue([1,4,2,9,1,3]))
console.log(hasDuplicateValue([1,4,2,9,5,3]))