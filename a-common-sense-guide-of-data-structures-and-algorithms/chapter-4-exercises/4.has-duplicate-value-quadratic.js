function hasDuplicateValue(array) {
    let steps = 0
    for(let i = 0; i < array.length; i++) {
        for(let j = 0; j < array.length; j++) {
            steps++
            if(j !== i && array[i] === array[j]) {
                return true
            }
        }
    }
    console.log(`Steps: ${steps}`)
    return false
}

console.log(hasDuplicateValue([1,4,2,9,1,3]))
console.log(hasDuplicateValue([1,4,2,9,5,3]))