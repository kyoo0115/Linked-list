Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.LinkedList$ListItr.checkForComodification(LinkedList.java:970)
	at java.base/java.util.LinkedList$ListItr.next(LinkedList.java:892)
	at Main.play(Main.java:51)
	at Main.main(Main.java:32)

Currently having this issue. I suppose using iteration.next() gives an exception error.