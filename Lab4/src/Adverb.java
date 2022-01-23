public enum Adverb {

        DESPERATELY("отчаянно"),
        LOUDLY("громко"),
        WAITING("выжидающе"),
        INTENTLY("пристально"),
        QUIET("тихо");

        private final String translation;

        Adverb(String translation) {
            this.translation = translation;
        }

        public String getTranslation() { return translation; }

}