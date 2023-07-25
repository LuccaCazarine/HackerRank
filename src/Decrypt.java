public class Decrypt {
            public static String decryptMessage(String encryptedMessage) {
                StringBuilder decrypted = new StringBuilder();

                String[] words = encryptedMessage.split(" ");

                for (int i = words.length - 1; i >= 0; i--) {
                    String word = words[i];
                    int len = word.length();
                    int j = 0;

                    while (j < len) {
                        char currentChar = word.charAt(j);
                        int frequency = 1;

                        while (j + frequency < len && word.charAt(j + frequency) == currentChar) {
                            frequency++;
                        }

                        if (frequency > 1) {
                            decrypted.append(currentChar).append(frequency);
                        } else {
                            decrypted.append(currentChar);
                        }

                        j += frequency;
                    }

                    if (i > 0) {
                        decrypted.append(' ');
                    }

                }

                return decrypted.toString();
            }

            public static void main(String[] args) {
                String encrypted = "world hel20";
                String decrypted = decryptMessage(encrypted);
                System.out.println(decrypted);
            }
        }