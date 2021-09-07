def​ ​print_every_other​(low, high)
  ​return​ ​if​ low > high
​  puts low
  print_every_other(low + 2, high)
end​

print_every_other(0, 10)