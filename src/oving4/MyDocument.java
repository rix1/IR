package oving4;

import java.awt.TextField;
import java.io.File;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Fieldable;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.util.IndexableBinaryStringTools;

/*
 * The task is to update the given `MyDocument' class (i.e implement the 'Document(File F)' method) to index the following fields per document:
 *
 * - path, the path of the file
 * - from, whatever is stored in the from field of the given message
 * - subject, the subject of the e-mail
 * - contents, the actual e-mail contents
 *
 * All `from', `subject', and `contents' should be searchable, i.e. store their re- spective term vectors. 
 * Look at the given `NewsDocument' class that reads a text file and has better methods for `from', `subject', and `contents'.
 *
 * =============
 *
 * I think this page contains relevant info: 
 * http://lucene.apache.org/core/3_0_3/fileformats.html 
 *
 * I ended up following these instructions: http://oak.cs.ucla.edu/cs144/projects/lucene/
 *
 */


public class MyDocument{

	public static Document Document (File f) throws java.io.FileNotFoundException{

		// make a new, empty document
		Document doc = new Document();

		// use the news document wrapper
		NewsDocument newsDocument = new NewsDocument(f);

		// WHATTAFAKK IS GOING ON HERE?
		Field path = new Field("path", newsDocument.getPath(),  Field.Store.YES, Field.Index.ANALYZED_NO_NORMS);
		Field from = new Field("from", newsDocument.getFrom(),  Field.Store.YES, Field.Index.ANALYZED);
		Field subject= new Field("subject", newsDocument.getSubject(),  Field.Store.YES, Field.Index.ANALYZED);
		Field contents= new Field("content", newsDocument.getContent(),  Field.Store.YES, Field.Index.ANALYZED);
		
		doc.add(path);
		doc.add(from);
		doc.add(subject);
		doc.add(contents);
		
		return doc;
	}

}
