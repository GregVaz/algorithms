function missingAlpha(letter) {
  let hashTable = {}
  let alpha = "abcdefghijklmnopqrstuvwxyz"

  for (const value of letter) {
    if(/[a-zA-Z]/.test(value)) {
      hashTable[value] = true
    }
  }

  for (const value of alpha) {
    if(!hashTable[value]) {
      return value
    }
  }

  return undefined
}

console.log(missingAlpha("the quick brown box jumps over a lazy dog"))