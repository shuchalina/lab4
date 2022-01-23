public class FormidableHead extends Hero {

        public FormidableHead(String name, Location location) {
            super(name, location);
            System.out.println(String.format("Создан персонаж: %s. Локация: %s.\n", this.getName()));
        }


        @Override
        public void changeLocation(Location location) {

            System.out.println(String.format("%s отправляется из '%s' в '%s'.\n", this.getName(), this.getLocation().getName(), location.getName()));
            this.setLocation(location);

        }

        public class RightProtrudingEye {

            public void see() {
                System.out.println("Правый выпученный глаз смотрит.");
            }

        }

        public class LeftProtrudingEye {

                public void see() {
                    System.out.println("Левый выпученный глаз смотрит.");
                }

        }

}
