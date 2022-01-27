public abstract interface UserList {
    /**
     * Creates a getType String interface that allows each list/child to be able to have a type associated with it
     * @param name is the username of the account
     * @param pass is the password of the username
     * @return this doesn't return anything inside this method but in the children it will return a string
     */
    public abstract String getType(String name, String pass);
}