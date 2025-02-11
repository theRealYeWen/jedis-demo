# Jedis-demo

This is a Jedis demo project that demonstrates two different implementation approaches: Basic Implementation and Connection Pool-Based Implementation.

## Basic Implementation
The basic implementation includes the following steps:

Add the Jedis dependency.

Create a Jedis object and establish a connection.

Use the Jedis object to interact with Redis. Jedis commands are consistent with native Redis commands.

Release resources (close the Jedis connection) after operations are completed.

### Connection Pool-Based Implementation
The connection pool-based implementation differs from the basic approach in the following ways:

A configuration factory class is required to initialize the Jedis connection pool.

Configure connection pool parameters (e.g., maximum connections, maximum idle connections) in the factory class.

Instead of manually creating a Jedis object, retrieve a Jedis instance from the connection pool.

After completing operations, return the Jedis instance to the connection pool.

The connection pool approach is more suitable for production environments, as it efficiently manages connection resources and avoids the performance overhead of frequently creating and destroying connections.