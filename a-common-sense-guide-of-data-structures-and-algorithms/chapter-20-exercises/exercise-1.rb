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

class Exercise1
  attr_accessor :basketball_players, :football_players

  def initialize(basketball_players, football_players)
    @basketball_players = basketball_players
    @football_players = football_players
  end

  def players_in_both_sports
    hash_basquetball_players = {}
    players_in_both_sports = []

    @basketball_players.each do |player|
      name = player[:first_name] + player[:last_name]
      hash_basquetball_players[name] = true
    end

    @football_players.each do |player|
      name = player[:first_name] + player[:last_name]
      players_in_both_sports << player[:first_name] + " " + player[:last_name] if hash_basquetball_players[name]
    end

    players_in_both_sports
  end
end


exercise = Exercise1.new(basketball_players, football_players)
puts exercise.players_in_both_sports