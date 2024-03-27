public class Gallows {
    static void printGallows(int stageNumber) {
        switch (stageNumber) {
            case 0 -> System.out.println("""
                      ________
                      |/     !
                      |
                      |
                      |
                      |
                      |
                      |
                    --|---------
                    """);

            case 1 -> System.out.println("""
                      ________
                      |/     !
                      |     (_)
                      |
                      |
                      |
                      |
                      |
                      |
                    --|---------
                    """);

            case 2 -> System.out.println("""
                      ________
                      |/     !
                      |     (_)
                      |      |
                      |      |
                      |      |
                      |
                      |
                      |
                    --|---------
                    """);

            case 3 -> System.out.println("""
                      ________
                      |/     !
                      |     (_)
                      |    --|
                      |   /  |
                      |      |
                      |
                      |
                      |
                    --|---------
                    """);
            case 4 -> System.out.println("""
                      ________
                      |/     !
                      |     (_)
                      |    --|--
                      |   /  |  \\
                      |      |
                      |
                      |
                      |
                    --|---------
                    """);
            case 5 -> System.out.println("""
                      ________
                      |/     !
                      |     (_)
                      |    --|--
                      |   /  |  \\
                      |      |
                      |     /
                      |    /
                      |
                    --|---------
                    """);
            case 6 -> System.out.println("""
                      ________
                      |/     !
                      |     (_)
                      |    --|--
                      |   /  |  \\
                      |      |
                      |     / \\
                      |    /   \\
                      |
                    --|---------
                    """);
        }
    }
}
