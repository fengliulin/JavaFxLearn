package cc.chengheng.plugin;

import groovy.lang.Closure;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GreetingPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.task("hello", task -> {
            System.out.println("你好");
        });
    }
}