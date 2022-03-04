public interface PostDao {

  Post createPost(Post data);

  List<Post> getPosts();

  Post getPost(int id);

  Post updatePost(int id, Post data);

  void deletePost(int id);
}
