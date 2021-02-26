<template>
  <div>
      <form class="new-book-form" v-on:submit.prevent="saveNewBook()">
          <input class="title-input" type="text" placeholder="Title" v-model="newBook.title">
          <input class="author-input" type="text" placeholder="Author" v-model="newBook.author">
          <input class="isbn-input" type="text" placeholder="ISBN" v-model="newBook.isbn">
          <button type="submit">Submit</button>
      </form>
  </div>
</template>

<script>
export default {
    data(){
        return{
            newBook:{
                read:false,
            }
        }
    },
    methods: {
        saveNewBook(){
         this.$store.commit("SAVE_NEW_BOOK", this.newBook);
         this.resetForm();   
        },
        resetForm(){
            this.newBook ={};
        }
    }
}
</script>

<style>

</style>