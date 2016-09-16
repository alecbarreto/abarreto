var prime_check = function (number) {

  if (number < 2) {
    return false
  }
  if (number === 2) {
    return true
  }

  else {
    for (var i = 2; i < number; i++) {

      if (number % i === 0) {
        return false
      }
      else if (i === (number - 1)) {
        return true
      }
    }
  }
}

console.log(prime_check(2));
