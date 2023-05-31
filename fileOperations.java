import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class fileOperations {
	public void viewAllFiles() {
		File dir = new File("/Users/palani/Desktop/Assessment");
		String[] files = dir.list();
		if (files == null)
			System.out.println("Directory is empty");
		else {
			Arrays.sort(files);
			System.out.println("List of Files:");
			for (String file : files) {
				System.out.println(file);
			}
		}
	}

	public void addNewFile(String fileName, String content) throws IOException {
		File dir = new File("/Users/palani/Desktop/Assessment");
		String[] files = dir.list();
		for (String file : files) {
			if (fileName.equals(file)) {
				System.out.println("File is already present in the system");
				return;
			}
		}
		File file = new File("/Users/palani/Desktop/Assessment/" + fileName + ".txt");
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		fw.write(content);
		fw.close();
		System.out.println("A new file has been created");
	}

	public void deleteFile(String fileName) {
		boolean fileDeleted = false;
		File dir = new File("/Users/palani/Desktop/Assessment");
		File[] files = dir.listFiles();
		if (files == null)
			System.out.println("Directory is empty");
		else {
			for (File file : files) {
				if (fileName.equals(file.getName())) {
					file.delete();
					System.out.println("File deleted successfully");
					fileDeleted = true;
				}
			}
			if (!fileDeleted)
				System.out.println("File is not present in the system");
		}
	}

	public void searchFile(String fileName) {
		boolean fileFound = false;
		File dir = new File("/Users/palani/Desktop/Assessment");
		String[] files = dir.list();
		if (files == null)
			System.out.println("Directory is empty");
		else {
			for (String file : files) {
				if (fileName.equals(file)) {
					System.out.println("File is present in the system");
					fileFound = true;
				}
			}
			if (!fileFound)
				System.out.println("File is not present in the system");
		}
	}
}
