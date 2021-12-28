function findTheMissingOne(array) {
  const n = array.length
  for(let i = 0; i < n; i++) {
    if (!array.includes(i)) {
      return i
    }
  }
  return array
}

const result1 = findTheMissingOne([2,3,0,6,1,5])
const result2 = findTheMissingOne([8,2,3,9,4,7,5,0,6])

console.log(result1)
console.log(result2)