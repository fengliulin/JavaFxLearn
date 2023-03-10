package cc.chengheng.Dukescript;

import com.dukescript.api.javafx.beans.FXBeanInfo;
import javafx.scene.web.WebView;
import net.java.html.boot.fx.FXBrowsers;
import net.java.html.json.Models;

import java.net.URL;

public class HTMLLoader {
    public static WebView load(URL html, final FXBeanInfo.Provider viewModel) {
        WebView webView = new WebView();
        FXBrowsers.load(webView, html, new Runnable() {
            @Override
            public void run() {
                Models.applyBindings(viewModel);
            }

        });
        return webView;
    }
}