import SwiftUI
import shared
import Combine
import KMPNativeCoroutinesAsync

struct ContentView: View {
    @ObservedObject var homeViewModel:HomeViewModel = HomeViewModel()
    private var columnSize = [GridItem(.flexible()), GridItem(.flexible())]
	var body: some View {
        NavigationView{
            ScrollView{
                LazyVGrid(columns:columnSize){
                    ForEach(homeViewModel.movies,id:\.id) { movie in
                        NavigationLink( destination:MovieDetail(movieDetail: movie)){
                            if #available(iOS 15.0, *) {
                                AsyncImage(url: URL(string:"https://image.tmdb.org/t/p/w500"+movie.poster_path)) { image in
                                    VStack {
                                        image
                                            .resizable()
                                            .aspectRatio(contentMode: .fill)
                                            .frame(minWidth:0,maxWidth:.infinity,minHeight:100)
                                        
                                        Text(movie.title)
                                            .font(.system(size: 16))
                                    }.frame( alignment: Alignment.center)
                                        .padding(EdgeInsets(top: 8, leading: 4, bottom: 8, trailing: 4))
                                } placeholder: {
                                    VStack {
                                        Image(systemName: "photo")
                                            .imageScale(.large)
                                            .frame(width: 110, height: 110)
                                        
                                        Text(movie.title)
                                            .padding(EdgeInsets(top: 8, leading: 8, bottom: 8, trailing: 8))
                                    }
                                }
                            } else {
                                VStack{
                                    ImageView(withURL:"https://image.tmdb.org/t/p/w500"+movie.poster_path)
                                        .frame(width: 100, height: 150)
                                    Text(movie.title)
                                }.frame( alignment: Alignment.center)
                            }
                        }
                    }
                }
            }
            .onAppear{
                homeViewModel.fetchMovies123()
            }.navigationBarTitle("Movie List",displayMode:.inline)
        }
    }
}


