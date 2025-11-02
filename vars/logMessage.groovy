/**
 * logMessage: Prints a message to the Jenkins console with a prefix.
 * Can be reused in any pipeline to standardize logging.
 *
 * @param msg The message to print
 */
def call(String msg = 'Hello from shared library!') {
    echo "💬 [Shared Lib] ${msg}"
}
