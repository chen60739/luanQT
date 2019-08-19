import org.junit.Test;

public class JiaMi {
        private static final String PASSWORD="123456";
        private static final int HASHITERATIONS=2;

        @Test
        public void test1() {
            /*普通加密*/
            //System.out.println(new Md5Hash(PASSWORD));
            /*加盐加密*/
            //System.out.println(new Md5Hash(PASSWORD, SALT));
           //System.out.println(new Md5Hash(PASSWORD,null, HASHITERATIONS));
            //SimpleHash simpleHash = new SimpleHash("MD5", PASSWORD, null, HASHITERATIONS);
            //System.out.println(simpleHash.toString());
                int id = (int)(Math.random()*1000);
                System.out.print(id);

        }

}
