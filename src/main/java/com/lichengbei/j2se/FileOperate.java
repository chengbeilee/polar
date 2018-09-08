package com.lichengbei.j2se;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileOperate {
	/*
	 * java中提供一行一行读取的类是 BufferedReader,其有一个readLine()方法
	 * java中提供一行一行写入的类是BufferedWriter,其有一个write()方法
	 */

	public static void main(String[] args) throws IOException {
		// // 以行为单位读出文本文件
		// readFileByline();

		// // 合并文本文件内容，并生成新文件
		// mergeFile();

		// // 以行为单位读取文件，同时指定编码格式为UTF-8
		// readFileByLineWithUTF8();

		// // 以行为单位写入文件，同时指定编码格式为UTF-8
		// writeFileByLineWithUTF8();

	}

	public static void writeFileByLineWithUTF8() {
		String filename = System.getProperty("user.dir") + "/Folder1/FileOperateDemo3.txt";
		String[] content = { "我是要输出的第一行内容！", "哈哈，我是第二行的！" };

		try {
			FileOutputStream out = new FileOutputStream(filename);
			OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
			BufferedWriter bufWrite = new BufferedWriter(outWriter);
			for (int i = 0; i < content.length; i++) {
				bufWrite.write(content[i] + "\r\n");
			}
			bufWrite.close();
			outWriter.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读取" + filename + "出错！");
		}
	}

	public static void readFileByLineWithUTF8() {

		String filename = System.getProperty("user.dir") + "/Folder1/FileOperateDemo.txt";

		try {
			FileInputStream in = new FileInputStream(filename);
			InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			String line = null;
			int i = 1;
			while ((line = bufReader.readLine()) != null) {
				System.out.println("第" + i + "行：" + line);
				i++;
			}
			bufReader.close();
			inReader.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读取" + filename + "出错！");
		}

	}

	public static void mergeFile() throws IOException {

		// 准备要进行操作的文件与流对象
		File file = new File(System.getProperty("user.dir") + "/Folder1/FileOperateDemo.txt");
		File file2 = new File(System.getProperty("user.dir") + "/Folder1/FileOperateDemo2.txt");
		File fileMerge = new File(System.getProperty("user.dir") + "/Folder1/FileOperateMerged.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedReader reader2 = new BufferedReader(new FileReader(file2));
		FileWriter fileWriter = new FileWriter(fileMerge);

		// 读取要合并的文件，并将内容写入新文件
		try {
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				fileWriter.write(tempString + "\r\n");
				System.out.println("line " + line + ": " + tempString);
				if (tempString.contains(("陕西省"))) {
					while ((tempString = reader2.readLine()) != null) {
						fileWriter.write(tempString + "\r\n");
						System.out.println(tempString);
					}
				}
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
					reader2.close();
					fileWriter.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static void readFileByline() {
		String fileName = System.getProperty("user.dir") + "/Folder1/FileOperateDemo.txt";
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

}
