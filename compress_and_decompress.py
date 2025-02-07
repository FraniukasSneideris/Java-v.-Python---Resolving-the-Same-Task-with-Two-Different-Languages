def compress_string(word):
  compressed = ""
  num = 1
  
  if word:
    for i in range(0, len(word) - 1):
      if word[i] == word[i+1]:
        num += 1
      else:
        compressed += word[i] + str(num)
        num = 1
    
    compressed += word[-1] + str(num)
  
  return compressed

def decompress_string(word):
  decompressed = ""
  
  if word:
    for i in range(0, len(word), 2):
      decompressed += str(word[i] * int(word[i+1]))

  return decompressed

example1 = "aaabbbcccdeefgg"
example2 = "a3b3c3d1e2f1g2"
example3 = ""
print(f"Compress aaabbbcccdeefgg: {compress_string(example1)}")
print(f"Compress empty string: {compress_string(example3)}")
print(f"Decompress a3b3c3d1e2f1g2: {decompress_string(example2)}")
print(f"Decompress empty string: {decompress_string(example3)}")
