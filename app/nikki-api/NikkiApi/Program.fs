open System
open Microsoft.AspNetCore.Builder
open Microsoft.Extensions.Hosting

[<EntryPoint>]
let main args =
    let builder = WebApplication.CreateBuilder(args)
    let app = builder.Build()
    
    app.MapGet("/", Func<string>(fun () -> "Hello World!")) |> ignore
    

    // app.MapPost("/nikki",  Func<request, Task<IResult>>) {
    //     return Results.Ok("Hello World!")
    // }
    // |> ignore
    
    app.Run()
    0 // Exit code
