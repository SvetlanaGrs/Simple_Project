package io.project.pages;

public class POM {
   private GoogleSearchPage googleSearchPage;

    public GoogleSearchPage getGoogleSearchPage() {
        if(googleSearchPage == null){
            googleSearchPage=new GoogleSearchPage();
        }
        return googleSearchPage;
    }

}
