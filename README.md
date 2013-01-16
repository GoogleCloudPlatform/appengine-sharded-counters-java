# Sharded Counters for App Engine Java

A simple application that demonstrates two approaches to sharding counters.

To achieve higher throughput across different instances, counters can be
sharded to avoid concurrency issues. This application performs this in
two different ways:

- Simple Sharding: Uses a constant to define the number of shards and randomly
  picks an index up to this number when incrementing the counter. Each shard is
  stored in the datastore using one of these indices as ID.

- General Sharding: Stores the number of shards in the datastore and randomly
  picks an index up to this number when incrementing the counter. Each shard is
  stored in the datastore using one of these indices as ID, but also using a
  counter name as an ancestor.

## Products
- [App Engine][1]

## Language
- [Java][2]

## APIs
- [Datastore Java API][3]
- [Memcache Java API][4]


[1]: https://developers.google.com/appengine
[2]: http://java.com/en/
[3]: https://developers.google.com/appengine/docs/java/datastore/overview
[4]: https://developers.google.com/appengine/docs/java/memcache/overview

