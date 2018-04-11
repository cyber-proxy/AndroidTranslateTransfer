package com.lionmobi.exporting;

import java.util.HashSet;
import java.util.Set;

import com.lionmobi.util.CommonConfig;


/**
 * Created by tomas on 03.10.14.
 */
public class ExportConfig extends CommonConfig {

    public String inputExportProject;
    public String outputFile;
    public Set<String> additionalResources;

    public ExportConfig() {
        super();
        this.additionalResources = new HashSet<String>();
    }

    public ExportConfig(ExportConfig other) {
        super(other);
        this.inputExportProject = other.inputExportProject;
        this.outputFile = other.outputFile;
        this.additionalResources = new HashSet<String>(other.additionalResources);
    }

//    public ExportConfig(CommandlineArguments args) {
//        super(args);
//        this.inputExportProject = args.getExportProject();
//        this.outputFile = args.getOutputFile();
//        this.additionalResources = new HashSet<String>();
//        addAdditionalResources(args.getAdditionalResources());
//    }

    private void addAdditionalResources(String additionalResourcesRaw) {
        if (additionalResourcesRaw == null) {
            return;
        }
        for (String resName : additionalResourcesRaw.split(":")) {
            if (!resName.endsWith(".xml")) {
                resName = resName + ".xml";
            }
            additionalResources.add(resName);
        }
    }
}
