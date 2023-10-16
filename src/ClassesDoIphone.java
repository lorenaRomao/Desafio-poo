import java.util.Collection;


public class ClassesDoIphone{
    public static void main (String[] args) throws Exception {

    }
	private class Music {
        protected String title;
        
		private Music(String title, String artist, String album) {
            this.title = title;
        }
    }
	public interface MediaPlayer {
        public void play(Music music);

        public void pause();

        public void selectMusic(Music music);
    }

    public class iTunes implements MediaPlayer {
        private Music currentMusic = null;
        private boolean isPlaying = false;

        @Override
        public void play(Music music) {
            if (this.isPlaying) {
                this.pause();
            }
            this.currentMusic = music;
            this.isPlaying = true;
            System.out.println("Playing " + this.currentMusic.title + "...");
        }

        @Override
        public void pause() {
            this.isPlaying = false;
            System.out.println("Paused");
        }
        
		@Override
        public void selectMusic(Music music) {
            this.currentMusic = music;
            this.play(music);
        }
    }

    private class Contact {
        protected String phoneNumber;

     
        private Contact(String name, String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

    public interface PhoneCall {
        public void call();

        public void answer();

        public void voiceMail();
    }


    public class Phone implements PhoneCall {
        private boolean isCalling = false;
        private Contact caller = null;

        @Override
        public void call() {
            if (this.isCalling) {
                this.voiceMail();
            }
            this.isCalling = true;
            System.out.println("Calling " + this.caller.phoneNumber + "...");
        }

        @Override
        public void answer() {
            if (this.isCalling) {
                this.voiceMail();
            }
            this.isCalling = true;
            System.out.println(this.caller.phoneNumber + " is calling...");
        }

        @Override
        public void voiceMail() {
            this.isCalling = false;
            System.out.println("Voice mail from " + this.caller.phoneNumber);
        }
    }

    
    private class InternetPage {
        protected String uri;
        protected boolean isLoaded;

        
        private InternetPage(String uri, boolean isLoaded) {
            this.uri = uri;
            this.isLoaded = isLoaded;
        }

        
        public boolean getIsLoaded() {
            return this.isLoaded;
        }

        
        public void setIsLoaded(boolean isLoaded) {
            this.isLoaded = isLoaded;
        }
    }

    
    public interface InternetBrowser {
        public void viewInternetPage(String uri);

        public void refreshInternetPage();
    }

    
    public class Safari implements InternetBrowser {
        private Collection<InternetPage> tabs;
        private InternetPage currentTab = null;

        
        public Safari(Collection<InternetPage> tabs) {
            this.tabs = tabs;
        }

        
        public void AddNewTab(String uri) {
            if (uri == null) {
                this.tabs.add(new InternetPage("about:blank", false));
            } else {
                this.tabs.add(new InternetPage(uri, false));
            }
            System.out.println("New tab added");
        }

        
        @Override
        public void viewInternetPage(String uri) {
            this.currentTab = new InternetPage(uri, true);
            System.out.println("Viewing " + this.currentTab.uri + "...");
        }

        
        @Override
        public void refreshInternetPage() {
            if (this.currentTab == null) {
                throw new NullPointerException("No page to refresh");
            } else {
                this.currentTab.setIsLoaded(false);
                System.out.println("Refreshing " + this.currentTab.uri + "...");
            }
        }
    }
}

    
}
