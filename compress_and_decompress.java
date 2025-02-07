public class Main {
    public static void main(String[] args) {
        String example1 = "aaabbbcccdeefgg";
        String example2 = "a3b3c3d1e2f1g2";
        String example3 = "";
        System.out.println("Compress aaabbbcccdeefgg: " + compressString(example1));
        System.out.println("Compress empty string: " + compressString(example3));
        System.out.println("Decompress a3b3c3d1e2f1g2: " + decompressString(example2));
        System.out.println("Decompress empty string: " + decompressString(example3));
    }

    static String compressString(String word) {
        String compressed = "";
        int num = 1;

        if (!word.isEmpty()) {
            for (int i = 0; i < word.length() - 1; i++) {
                if (word.charAt(i) == word.charAt(i + 1)) {
                    num += 1;
                } else {
                    compressed += word.charAt(i) + Integer.toString(num);
                    num = 1;
                }
            }
            compressed += word.charAt(word.length() - 1) + Integer.toString(num);  
        }

        return compressed;
    }

    static String decompressString(String word) {
        String decompressed = "";

        if (!word.isEmpty()) {
            for (int i = 0; i < word.length(); i += 2) {
                char c = word.charAt(i);
                int repeatCount = word.charAt(i + 1) - '0'; 
                decompressed += String.valueOf(c).repeat(repeatCount);
            }
        }

        return decompressed;    
    }
}
