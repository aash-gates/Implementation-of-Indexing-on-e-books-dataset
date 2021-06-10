# File-structures-mini-project/Indexing
In this project i have developed indexing for both primary and secondary using eclipse for java as IDE.Indexing  is the process of associating a key with the location of a corresponding data record.
An external sort typically uses the concept of  a  key sort,in which an index file is created wh-
ose  records consist of  keypairs.Here,each key is associated with a pointer to a  complete rec-
ord in the main database file.The index file could be sorted or organised using a tree structure,
thereby imposing a logical order on the records without physically rearranging them.Each rec-
ord of  a database  normally has a unique identifier ,called the primary key.A particular key v-
alue might be duplicated in multiple records,is called a secondary key.The secondary key ind-
ex will associate a secondary key value with the primary key of each record having that  seco-
ndary  key value .The full database might be searched directly for the record with that primary
key,or there might be a primary key index that relates each primary key value with  a   pointer
to the actual record on the disk.In this case,the primary index  provides the location of the act
-ual  record on disk,while the secondary disk indices refer to the primary index.Indexing is an important technique for organising large databases. 

