package Src;



public class SplashScreen {

    public static void main(String[] args) {
        Splash sp = new Splash();
        sp.setVisible(true);
        MusicPlayer mp = new MusicPlayer();
        try{
            for(int i=0;i<=100;i++){
                Thread.sleep(10);
//                sp.splashProgress.setValue(i);
                if(i == 100){
                    sp.dispose();
                    mp.setVisible(true);
                }
            }
        }
        catch(InterruptedException ex)
        {
            
        }
    }
    
}
