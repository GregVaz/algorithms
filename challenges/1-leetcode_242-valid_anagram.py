class Solution:
	def isAnagram(self, s: str, t: str) -> bool:
		# First solution O(n)
		if len(s) != len(t):
			return False
		countS, countT = {}, {}
		for i in range(len(s)):
			countS[s[i]] = countS.get(s[i], 0) + 1
			countT[t[i]] = countT.get(t[i], 0) + 1
		for c in countS:
			if countS[c] != countT.get(c, 0):
				return False
		return True

		# Second solution O(n)
		return Counter(s) == Counter(t)

		# Third solution O(1)
			# assuming the sort algorithm takes memory O(1)
		return sorted(s) == sorted(t)