basketball_players = [
  {first_name: "Jill", last_name: "Huang", team: "Gators"},
  {first_name: "Janko", last_name: "Barton", team: "Sharks"},
  {first_name: "Wanda", last_name: "Vakulskas", team: "Sharks"},
  {first_name: "Jill", last_name: "Moloney", team: "Gators"},
  {first_name: "Luuk", last_name: "Watkins", team: "Gators"}
]

football_players = [
  {first_name: "Hanzla", last_name: "Radosti", team: "32ers"},
  {first_name: "Tina", last_name: "Watkins", team: "Barleycorns"},
  {first_name: "Alex", last_name: "Patel", team: "32ers"},
  {first_name: "Jill", last_name: "Huang", team: "Barleycorns"},
  {first_name: "Wanda", last_name: "Vakulskas", team: "Barleycorns"}
]

function findPlayersInBothSports(basketball_players, football_players) {
  let hashBasketaballPlayers = {}
  const bothSports = []

  for (let player of basketball_players) {
    let name = player.first_name + player.last_name
    hashBasketaballPlayers[name] = true
  }

  for (let player of football_players) {
    let name = player.first_name + player.last_name
    if (hashBasketaballPlayers[name]) {
      bothSports.push(player.first_name + " " + player.last_name)
    }
  }

  return bothSports
}

const result = findPlayersInBothSports(basketball_players, football_players)
console.log(result)