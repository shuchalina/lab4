public class Main {

    public static void main(String[] args) {

        Home moomintrollHome = new Home("Дом Муми-тролля");
        Moomintroll moomintroll = new Moomintroll("Муми-тролль", moomintrollHome, new String[]{"---", "---", "---"});

        Home snorkHome = new Home("Дом Снорка");
        Snork snork = new Snork("Снорк", snorkHome);

        moomintroll.think();
        snork.think();

        moomintroll.say("Все ясно, в ней то и дело!", Adverb.LOUDLY);
        snork.say("Все ясно, в ней то и дело!", Adverb.LOUDLY);

        Moomintroll.Head moomintrollHead = moomintroll.new Head(0);
        Snork.Head snorkHead = snork.new Head(0);

        moomintrollHead.turn(90);
        moomintroll.see(snork, Adverb.INTENTLY);

        snorkHead.turn(270);
        snork.see(moomintroll, Adverb.INTENTLY);

        moomintrollHead.shake(3);

        Jar bigJar = new Jar("Улица", Size.BIG);

        moomintroll.findJar(bigJar);
        moomintroll.checkInventory();

        Sea sea = new Sea("Море");
        moomintroll.changeLocation(sea);
        snork.changeLocation(sea);

        Coast coast = new Coast("Берег", CoastType.SANDY);
        moomintroll.changeLocation(coast);
        snork.changeLocation(coast);

        Home antLionHome = new Home("Дом Муравьиного льва");
        AntLion antLion = new AntLion("Муравьиный лев", antLionHome);

        antLion.changeLocation(coast);

        try{
            antLion.doHoles(3);
        }
        catch(HolesException ex){
            System.out.println(ex.getMessage());
        }

        Pit pit = new Pit(Size.BIG, Form.ROUND);
        snork.findPit(pit);

        Snork.Hand snorkHand = snork.new Hand();
        snorkHand.wave(Adverb.DESPERATELY);

        snork.say("Он тут!", Adverb.QUIET);
        snork.say("Только как мы заманим его в банку?", Adverb.QUIET);

        moomintroll.say("Это я возьму на себя.", Adverb.QUIET);

        moomintroll.buryTheJar(bigJar);
        System.out.println(bigJar.toString());

        moomintrollHead.turn(90);
        moomintroll.see(pit, Adverb.WAITING);

        snorkHead.turn(90);
        snork.see(pit, Adverb.WAITING);

        FormidableHead formidableHead = new FormidableHead("Грозная голова", coast);
        FormidableHead.LeftProtrudingEye leftEye = formidableHead.new LeftProtrudingEye();

        FormidableHead.RightProtrudingEye rightEye = formidableHead.new RightProtrudingEye();

        leftEye.see();
        rightEye.see();

    }
}

