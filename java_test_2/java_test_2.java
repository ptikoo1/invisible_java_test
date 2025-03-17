def longest_palindrome(s):
    """
    Given a string, find the longest palindromic substring within it.

    Args:
        s: The input string.

    Returns:
        The longest palindromic substring.
    """

    if not s:
        return ""

    longest = ""

    for i in range(len(s)):
        # Check for odd length palindromes
        l, r = i, i
        while l >= 0 and r < len(s) and s[l] == s[r]:
            if (r - l + 1) > len(longest):
                longest = s[l:r+1]
            l -= 1
            r += 1

        # Check for even length palindromes
        l, r = i, i + 1
        while l >= 0 and r < len(s) and s[l] == s[r]:
            if (r - l + 1) > len(longest):
                longest = s[l:r+1]
            l -= 1
            r += 1

    return longest
