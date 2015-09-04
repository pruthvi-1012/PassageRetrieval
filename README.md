
Apache Lucene provides a system that returns documents according to search queries. Passage Retrieval System modifies the API provided by Apache Lucene, so that it only return relevant pages rather than entire documents. PRS provides capabilities to select and score relevant passages within the queried document.

To make this actually work I have created a function, which divide whole document in to passages. After retrieval of individual passages, PRS checks relevant search terms and then it ranks passages according to scoring. After ranking each passages it is necessary to perform indexing so that the highest ranked passage retrieve first by lower ranked passage which avoids retrieval of whole document every time.

PRS improved the quality of result provided by Apache Lucene and it also avoids unnecessary and unwanted data during retrieval of information.
