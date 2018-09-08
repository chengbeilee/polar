package com.lichengbei.j2se;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;

public class YamlDemo1 {

	public static void main(String[] args) throws IOException {

		// Map数据准备
		Map<String, Object> root = new HashMap<String, Object>();
		Map<String, Object> score = new HashMap<String, Object>();
		Map<String, Object> classOne = new HashMap<String, Object>();
		Map<String, Object> classTwo = new HashMap<String, Object>();
		classOne.put("Polar", "96");
		classOne.put("Jack", "85");
		classTwo.put("Rose", "83");
		score.put("classOne", classOne);
		score.put("classTwo", classTwo);
		root.put("score", score);

		// 写入Yaml
		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		Yaml yaml = new Yaml(dumperOptions);
		File dumpFile = new File(System.getProperty("user.dir") + "/Folder1/Score.yaml");
		FileWriter fileWriter = new FileWriter(dumpFile);
		yaml.dump(root, fileWriter);
		fileWriter.close();

	}

}
