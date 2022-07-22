//
//  HomeViewModel.swift
//  moviewCatalogueIos
//
//  Created by Quipper on 15/07/22.
//  Copyright © 2022 orgName. All rights reserved.
//
import shared
import KMPNativeCoroutinesAsync
import Foundation

@MainActor
class HomeViewModel:ObservableObject{
    @Published var movies = [Result]()
    
    private var fetchMovies:Task<(),Never>? = nil
    
    func fetchMovies123(){
        Task{
            let result = await asyncResult(for: APIService().getTopRatedMoviesNative())
            if case let .success(movie) = result {
                self.movies = movie.results
            }
            if case let .failure(error) = result{
                print(error)
            }
        }
    }
}
