package com.meowool.mio

/**
 * Throws an [IllegalPathException] if this path is not exists. Otherwise returns itself.
 *
 * @param followLinks see [Path.notExists]
 */
inline fun Path.requireExists(
  followLinks: Boolean = true,
  lazyMessage: () -> Any = { "because $this does not exists." }
): Path {
  if (exists(followLinks).not()) {
    val message = lazyMessage()
    throw IllegalPathException(this, message.toString())
  }
  return this
}

/**
 * Throws an [IllegalPathException] if this path is already exists. Otherwise returns itself.
 *
 * @param followLinks see [Path.notExists]
 */
inline fun Path.requireNotExists(
  followLinks: Boolean = true,
  lazyMessage: () -> Any = { "because $this already exists." }
): Path {
  if (notExists(followLinks).not()) {
    val message = lazyMessage()
    throw IllegalPathException(this, message.toString())
  }
  return this
}

/**
 * Throws an [IllegalPathException] if this path is a file. Otherwise returns itself.
 *
 * @see Path.isDirectory
 */
inline fun Path.requireDirectory(
  lazyMessage: () -> Any = { "because $this is not a directory." }
): Path {
  if (isDirectory.not()) {
    val message = lazyMessage()
    throw IllegalPathException(this, message.toString())
  }
  return this
}

/**
 * Throws an [IllegalPathException] if this path is a directory. Otherwise returns itself.
 *
 * @see Path.isDirectory
 */
inline fun Path.requireRegularFile(
  lazyMessage: () -> Any = { "because $this is not a file." }
): Path {
  if (isRegularFile.not()) {
    val message = lazyMessage()
    throw IllegalPathException(this, message.toString())
  }
  return this
}